
def partitionv(list, mapping_f):
    state = mapping_f(list[0])
    current_partition = []
    res = []
    for item in list:
        if state == mapping_f(item):
            current_partition.append(item)
        else:
            res.append(current_partition)
            current_partition = [item]
            state = mapping_f(item)
    res.append(current_partition)
    return res

case1 = ['f', 'f', 'f', 't', 't']
case2 = ['f', 'f', 'f', 't']

print(partitionv(case1, lambda x: x == 't'))
print(partitionv(case2, lambda x: x == 't'))
