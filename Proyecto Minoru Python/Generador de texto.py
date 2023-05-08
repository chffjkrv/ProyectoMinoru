import os
import unicodedata
import numpy as np
import pandas as pd
from itertools import islice
from collections import Counter

# Abriendo y juntando todos los textos del corpus linguistico
corpus = [archivo for archivo in  os.listdir('Corpus Castellano') if archivo[-3:] == 'txt']
texto = ''
for archivo in corpus:
    texto += open('Corpus Castellano/'+archivo, 'r').read()

texto = texto.replace('\n', ' ') # Eliminando los saltos de linea
texto = ' '.join(texto.split()) # Eliminando espacios innecesarios
# Cambiando caracteres especiales a letras de uso comun
texto = str(unicodedata.normalize('NFKD', texto).encode('ASCII', 'ignore'))
texto = texto.lower() # Cambiando todo a minusculas

# Input del usuario:
# Orden 1: Cadena de Markov con memoria de la letra anterior
# Orden 2: Cadena de Markov con memoria de las 2 letras anteriores
# Orden 3: Cadena de Markov con memoria de las 3 letras anteriores
# ...
# Orden N: Cadena de Markov con memoria de las N letras anteriores
orden = input('\n  Orden de la cadena de Markov: ')
orden = int(orden)
# Numero de letras en la frase
longitud_frase = input('  Longitud de la frase generada: ')
longitud_frase = int(longitud_frase)

# Todas las tuplas formadas por N-1 letras consecutivas y sus frecuencias absolutas
tuplas = Counter([''.join(j) for j in zip(*[islice(texto,i,None) for i in range(orden)])])
tuplas = np.array(list(tuplas.items()))

# Abriendo archivo de la Matriz de Markov correspondiente creada en la fase
# de entrenamiento de la cadena de Markov correspondiente usando "matrices_markov.py"
markov_matrix = pd.read_pickle('Modelos de Markov/Markov_Matrix_'+str(orden))
alfabeto = list(markov_matrix.index) # Abecedario derivado del corpus

# Inicializando la frase (primeras letras)
frec_tuplas = tuplas[:, 1].astype(int)
frase = np.random.choice(tuplas[:, 0], p = frec_tuplas/float(sum(frec_tuplas)))

# Crea la frase letra a letra siguiendo la cadena de Markov
for i in range(longitud_frase):
    frase += np.random.choice(alfabeto, p = markov_matrix[frase[-orden:]].values)
print('\n   '+frase+'\n')
