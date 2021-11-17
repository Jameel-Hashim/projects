if __name__ == '__main__':
	time = '12:45:54PM' #input()

	h = time.split(':')[0]
	if time[8] == 'P':
		if h != '12':
			time = time.replace(h, str(int(h)+12))
		print(time.split('P')[0])
	else:
		if h == '12':
			time = time.replace(h, '00')
		print(time.split('A')[0])