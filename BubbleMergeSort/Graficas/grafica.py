import numpy as np
import matplotlib.pyplot as plt

# data to plot
n_groups = 3
means_frank = (0.000338125, 0.043956423, 4.662808418)
means_guido = (0.000183868, 0.003348684, 0.23565526)

# create plot
fig, ax = plt.subplots()
index = np.arange(n_groups)
bar_width = 0.35
opacity = 0.8

rects1 = plt.bar(index, means_frank, bar_width,
alpha=opacity,
color='b',
label='BubbleSort')

rects2 = plt.bar(index + bar_width, means_guido, bar_width,
alpha=opacity,
color='g',
label='Merge Sort')

axes = plt.gca()
axes.set_ylim([0,4.662808418])

plt.xlabel('Numero de elementos (n)')
plt.ylabel('Tiempo (seg)')
plt.title('Lista Aleatoria Desordenada')
plt.xticks(index + bar_width, ('50', '500', '5000'))
plt.legend()

plt.tight_layout()
plt.show()
