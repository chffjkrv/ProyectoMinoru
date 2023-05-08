import os
import unicodedata
import numpy as np
import pandas as pd
from tqdm import tqdm
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
texto = texto[:10000]
# Input del usuario:
# Orden 1: Cadena de Markov con memoria de la letra anterior
# Orden 2: Cadena de Markov con memoria de las 2 letras anteriores
# Orden 3: Cadena de Markov con memoria de las 3 letras anteriores
# ...
# Orden N: Cadena de Markov con memoria de las N letras anteriores
orden = input('  Orden de la cadena de Markov: ')
orden = int(orden)

alfabeto = Counter(texto).keys() # Abecedario derivado del corpus
# Todas las tuplas formadas por N-1 letras consecutivas y sus frecuencias absolutas
tuplas = Counter([''.join(j) for j in zip(*[islice(texto,i,None) for i in range(orden)])])

# Inicializando matriz de Markov
markov_matrix = pd.DataFrame(index = alfabeto, columns = tuplas.keys())
markov_matrix = markov_matrix.fillna(0)

# Rellenando la matriz de Markov (frecuencias absolutas de las tuplas
# encontradas en el corpus linguistico)
for i in tqdm(range(len(texto)-orden), leave = False):
    markov_matrix[texto[i:i+orden]][texto[i+orden]] += 1

# Normalizando matriz de Markov para que presente las frecuencias relativas (probabilidades)
cols = markov_matrix.columns.values
for col in cols:
    markov_matrix[col] = markov_matrix[col]/sum(markov_matrix[col])

# Guardando matriz de Markov
markov_matrix.to_pickle('Modelos de Markov/Markov_Matrix_'+str(orden))
