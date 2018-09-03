
def partitionv(list):
    state = list[0]
    current_partition = []
    res = []
    for item in list:
        if state == item:
            current_partition.append(item)
        else:
            res.append(current_partition)
            current_partition = [item]
    if len(current_partition) > 1:
        res.append(current_partition)
    return res

case1 = ['f', 'f', 'f', 't', 't']
case2 = ['f', 'f', 'f', 't']

print(partitionv(case1))
print(partitionv(case2))
