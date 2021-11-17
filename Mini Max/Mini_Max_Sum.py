if __name__ == '__main__':
    array = input().split()
    sums = []

    for point in range(len(array)):
        sum = 0
        for count in range(len(array)):
            if count == point:
                continue
            sum += int(array[count])
        sums.append(sum)

    min = sums[0]
    max = sums[0]
    for i in range(1, len(sums)):
        if sums[i] < min:
            min = sums[i]
        elif sums[i] > max:
            max = sums[i]

    print(min,max)

