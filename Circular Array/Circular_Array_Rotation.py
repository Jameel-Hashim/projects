inputs = ['','1','3'] #input().split()
array = ['0','1','2'] #input().split()
predicts = ['0','1','2'] #[input() for i in range(int(inputs[2]))]

for index in predicts:
	array_index = int(index)-int(inputs[1])
	if int(index) == 0:
		array_index = len(array)-int(inputs[1])
	elif int(index) > len(array):
		array_index = int(index)
	print(array[array_index%len(array)])