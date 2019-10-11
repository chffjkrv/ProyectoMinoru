from collections import Counter
import unicodedata
import pandas as pd
import numpy as np
import os

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

alfabeto = np.sort(Counter(texto).keys()) # Abecedario derivado del corpus

# Lista de frecuencias absolutas de las letras del abecedario tal como aparecen
# en el corpus linguistico
frec = pd.DataFrame.from_dict(Counter(texto), orient = 'index', columns = ['Frec'])

# Normalizacion de la lista de frecuencias absolutas para convertirla en una
# lista de frecuencias relativas (probabilidades)
frec_norm = frec['Frec']/sum(frec['Frec'])

longitud_frase = 600 # Numero de letras en la frase

# Crear frase con letras aleatorias segun las frecuencias relativas encontradas
# en el corspus linguistico
frase = ''.join(np.random.choice(np.array(frec_norm.index), size = longitud_frase, replace = True, p = np.array(frec_norm)))
print('\n'+frase+'\n')
