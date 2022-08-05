#접근1
def solution(s):
    answer = s 
    answer = answer.replace('zero', '0')
    answer = answer.replace('one', '1')
    answer = answer.replace('two', '2')
    answer = answer.replace('three', '3')
    answer = answer.replace('four', '4')
    answer = answer.replace('five', '5')
    answer = answer.replace('six', '6')
    answer = answer.replace('seven', '7')
    answer = answer.replace('eight', '8')
    answer = answer.replace('nine', '9')

    return int(answer)



#깔끔한 풀이
num_dic = {"zero":"0", "one":"1", "two":"2", "three":"3", "four":"4", "five":"5", "six":"6", "seven":"7", "eight":"8", "nine":"9"}

def solution(s):
    answer = s
    for key, value in num_dic.items():
        answer = answer.replace(key, value)
    return int(answer)
