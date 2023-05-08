import os
import numpy as np
import pandas as pd
from tqdm import tqdm
from itertools import product
import matplotlib.pyplot as plt

def add_columns_and_rows(df, new_cols, new_rows):
    new_cols = pd.DataFrame(0, index = df.index, columns = new_cols)
    df = pd.concat([df, new_cols], axis = 1)
    new_rows = pd.DataFrame(0, index = new_rows, columns = df.columns)
    df = pd.concat([df, new_rows])
    return df

# Input del usuario:
# Orden 1: Cadena de Markov con memoria de la letra anterior
# Orden 2: Cadena de Markov con memoria de las 2 letras anteriores
# Orden 3: Cadena de Markov con memoria de las 3 letras anteriores
# ...
# Orden N: Cadena de Markov con memoria de las N letras anteriores
orden = input('\n  Orden de la cadena de Markov: ')
orden = int(orden)

# Crea carpeta para las gráficas (si no existe ya)
folder = 'Cajas Markov Orden '+str(orden)
if folder not in os.listdir('Distribuciones de letras por cajas'):
    os.mkdir('Distribuciones de letras por cajas/'+folder)

# Matriz de Markov para orden N-ésimo:
df = pd.read_pickle('Modelos de Markov/Markov_Matrix_'+str(orden))
# Elimina los casos donde aparece el guion bajo
df = df[[i for i in df.columns if '_' not in i]]
df = df.loc[[i for i in df.index if '_' not in i]]
# Sustituye los espacios por el caracter "_"
df = df.rename({col:col.replace(' ', '_') for col in df.columns.values}, axis = 'columns')
df = df.rename({idx:idx.replace(' ', '_') for idx in df.index.values}, axis = 'index')
# Seleccionar los caracteres y tuplas en los que estamos interesados:
characters = ['_']+list('abcdefghijklmnopqrstuvwxyz')
character_permutations = [''.join(tuple) for tuple in product(characters, repeat = orden)]
# Añadir columnas y filas de zeros a la matriz para representar las tuplas y caracteres ausentes en los datos.
new_col = []
for tuple in character_permutations:
    if tuple not in df.columns.values:
        new_col.append(tuple)
new_indx = []
for char in characters:
    if char not in df.index.values:
        new_indx.append(char)
df = add_columns_and_rows(df, new_col, new_indx)
# Seleccionar la región de la matriz con caracteres y tuplas en los que estamos interesados:
df = df[character_permutations]
df = df.loc[characters]
cols = df.columns.values
for col in cols:
    if sum(df[col]) != 0.0:
        df[col] = df[col]/sum(df[col])

# Plots
indx = df.index.values
plt.style.use('dark_background')
for col in tqdm(cols):
    v = np.array(sorted(zip(df[col].values, df.index.values))[::-1])
    freq = v[:,0].astype(float)
    labels = v[:,1]
    plt.figure(figsize = (10, 6.5))
    plt.bar(x = range(len(labels)), height = freq*100, tick_label = labels, color = 'm')
    plt.title('Distribución de probabilidad para la siguiente letra tras: '+col, size = 15)
    plt.xlabel('Símbolos', size = 20)
    plt.ylabel('Frecuencia (%)', size = 20)
    plt.xticks(fontsize = 17)
    if sum(df[col]) == 0.0:
        plt.ylim([0, 0.01])
    plt.savefig('Distribuciones de letras por cajas/'+folder+'/'+col.upper()+'.png', dpi = 200)
    plt.close()
