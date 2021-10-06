
import re
import nltk
import multiprocessing
from gensim.models import Word2Vec
from unicodedata import normalize
from nltk.corpus import stopwords
from time import time
from sys import getsizeof
import os

import logging  

logging.basicConfig(format="%(levelname)s - %(asctime)s: %(message)s", datefmt= '%H:%M:%S', level=logging.INFO)
corpus = [archivo for archivo in  os.listdir(os.getcwd()) if archivo[-3:] == 'txt']
texto = ''
cont = 0
t = time()
for archivo in corpus:

    txt = open(archivo, 'r').read()
    txt = txt.lower()
    txt = re.sub(
        r"([^n\u0300-\u036f]|n(?!\u0303(?![\u0300-\u036f])))[\u0300-\u036f]+", r"\1", 
        normalize( "NFD", txt), 0, re.I
    )
    cont += 1
    texto += txt
    print('van '+ str(cont) +'libros normalizados en memoria')

SizeDataMb = getsizeof(texto)/1000000
print('El texto tiene un tamaño en memoria de'+str(SizeDataMb)+'Mb')




print('Normalización del texto terminada')
print('Tiempo de normalización: {} mins'.format(round((time() - t) / 60, 2)))

t = time()
frases = nltk.sent_tokenize(texto)
print('Tokenización de frases completada') 
print('Tiempo de tokenización de frases: {} mins'.format(round((time() - t) / 60, 2)))

t = time()
palabras = [nltk.word_tokenize(sent) for sent in frases]
print('Tokenización de palabras completada')
print('Tiempo de tokenización de palabras: {} mins'.format(round((time() - t) / 60, 2)))

t = time()
for i in range(len(palabras)):
    palabras[i] = [w for w in palabras[i] if w not in stopwords.words('spanish')]
print('Retiradas palabras de parada')
print('Tiempo de tokenización de palabras: {} mins'.format(round((time() - t) / 60, 2)))
cores = multiprocessing.cpu_count()

t = time()
modeloW2V = Word2Vec(min_count=20,
                     window=2,
                     sample=6e-5, 
                     alpha=0.03, 
                     min_alpha=0.0007, 
                     negative=20,
                     workers=cores-1)
print('Creación del modelo')
print('Tiempo de creación del modelo: {} mins'.format(round((time() - t) / 60, 2)))

t = time()
modeloW2V.build_vocab(palabras, progress_per=10000)
print('Generación del vocabulario, completado.')
print('Tiempo de generación del vocabulario: {} mins'.format(round((time() - t) / 60, 2)))

t = time()
modeloW2V.train(palabras, total_examples=modeloW2V.corpus_count, epochs=30, report_delay=1)
print('Entrenamiento del modelo COMPLETADÍSIMO')
print('Tiempo de entrenamiento: {} mins'.format(round((time() - t) / 60, 2)))

