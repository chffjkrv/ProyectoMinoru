from collections import Counter
import unicodedata
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

longitud_frase = 600 # Numero de letras en la frase

# Crear frase con letras aleatorias (equiprobables) vistas en el corpus
frase = ''.join(np.random.choice(alfabeto, size = longitud_frase, replace = True))
print('\n'+frase+'\n')
