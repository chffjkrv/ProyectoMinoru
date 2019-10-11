from collections import Counter
from itertools import islice
import os
import unicodedata
import numpy as np
import pandas as pd

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

# Abriendo archivo de la Matriz de Markov correspondiente creada en la fase
# de entrenamiento de la cadena de Markov correspondiente usando "matrices_markov.py"
markov_matrix = pd.read_pickle('Markov_Matrix_'+str(orden-1))

longitud_frase = 600 # Numero de letras en la frase

# Inicializando la frase
frec_tuplas = np.array(tuplas.values())
frase = np.random.choice(tuplas.keys(), p = frec_tuplas/float(sum(frec_tuplas)))

# Crea la frase letra a letra siguiendo la cadena de Markov
for i in range(longitud_frase):
    frase += np.random.choice(alfabeto, p = markov_matrix[frase[-orden+1:]].values)
print('\n'+frase+'\n')
