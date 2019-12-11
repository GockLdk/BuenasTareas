import matplotlib.pyplot as plt; plt.rcdefaults()
import numpy as np
import matplotlib.pyplot as plt

objects = ('10', '100', '1000','10000') # Eje X
y_pos = np.arange(len(objects))
performance = [0.000102441  ,0.000115554 ,0.001088142 ,0.018437147] # Eje Y


plt.bar(y_pos, performance, align='center', alpha=0.5)
plt.xticks(y_pos, objects)
plt.ylabel('Tiempo')    
plt.xlabel('n')
plt.title('Radix Sort Mejor Caso')

plt.show()
