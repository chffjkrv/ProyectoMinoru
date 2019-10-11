import os
import sys
import time
import unicodedata
import numpy as np
import pandas as pd
from itertools import islice
from collections import Counter
from sklearn import preprocessing

# Funcion que crea una barra de progreso para saber el estado de ejecución de
# de un bucle de larga duracion
def progress(it, itmax, step_percent):
    bar_size = 60
    mark = u'\u2588'
    limits = '|'
    percent = float(it)*100/itmax
    if int(step_percent) == step_percent:
        n_decimal = 0
    else:
        split = list(str(step_percent))
        n_decimal = len(split)-split.index('.')-1
    if it%int(itmax*(step_percent/100.)) == 0:
        if it < itmax:
            bar_marks = int(round(bar_size*it/itmax))
            bar = ' '+limits+mark*bar_marks+' '*(bar_size-bar_marks)+limits
            sys.stdout.write("  "+str(round(percent ,n_decimal))+" %"+bar+'\r')
        else:
            bar = ' '+limits+mark*bar_size+limits
            sys.stdout.write("  "+str(100)+" %"+bar+' COMPLETED')
    sys.stdout.flush()

# Abriendo y juntando todos los textos del corpus linguistico
corpus = [archivo for archivo in  os.listdir(os.getcwd()) if archivo[-3:] == 'txt']
texto = ''
for archivo in corpus:
    texto += open(archivo, 'r').read()

texto = texto.replace('\n', ' ') # Eliminando los saltos de linea
texto = ' '.join(texto.split()) # Eliminando espacios innecesarios
texto = unicode(texto, 'utf-8') # Dando formato UTF-8
# Cambiando caracteres especiales a letras de uso comun
texto = unicodedata.normalize('NFKD', texto).encode('ASCII', 'ignore')
texto = texto.lower() # Cambiando todo a minusculas

# Input del usuario:
# Orden 2: Cadena de Markov con memoria de la letra anterior
# Orden 3: Cadena de Markov con memoria de las 2 letras anteriores
# Orden 4: Cadena de Markov con memoria de las 3 letras anteriores
# ...
# Orden N: Cadena de Markov con memoria de las N-1 letras anteriores
orden = input('  Orden de la cadena de Markov: ')

alfabeto = Counter(texto).keys() # Abecedario derivado del corpus
# Todas las tuplas formadas por N-1 letras consecutivas y sus frecuencias absolutas
tuplas = Counter([''.join(j) for j in zip(*[islice(texto,i,None) for i in range(orden-1)])])

# Inicializando matriz de Markov
markov_matrix = pd.DataFrame(index = alfabeto, columns = tuplas.keys())
markov_matrix = markov_matrix.fillna(0)

# Rellenando la matriz de Markov (frecuencias absolutas de las tuplas
# encontradas en el corpus linguistico)
for i in range(len(texto)-orden+1):
    markov_matrix[texto[i:i+orden-1]][texto[i+orden-1]] += 1
    progress(i, len(texto)-orden, 0.1)
print('\n')

# Normalizando matriz de Markov para que presente las frecuencias relativas (probabilidades)
markov_matrix = pd.DataFrame(preprocessing.normalize(markov_matrix.values.transpose(), norm='l1').transpose(), index = alfabeto, columns = tuplas.keys())

# Guardando matriz de Markov
markov_matrix.to_pickle('Markov_Matrix_'+str(orden-1))
