import matplotlib.pyplot as plt; plt.rcdefaults()
import numpy as np
import matplotlib.pyplot as plt

objects = ('10', '100', '1000') # Eje X
y_pos = np.arange(len(objects))
performance = [2.61466E-05,0.001058817,0.059054375] # Eje Y


plt.bar(y_pos, performance, align='center', alpha=0.5)
plt.xticks(y_pos, objects)
plt.ylabel('Tiempo')    
plt.xlabel('n')
plt.title('Quick Sort Lista Ordenada Desc.')

plt.show()
