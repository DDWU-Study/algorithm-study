
def main():
	board = [[0,0,0,0,0],[0,0,1,0,3],[0,2,5,0,1],[4,2,4,4,2],[3,5,1,3,1]]
	moves = [1,5,3,5,1,2,1,4]
	answer = 0
	basket = []

	#이 코드는 왜 계속 0이 나오는지..
	for move in moves: #크레인 몇번 움직였는지
		for each_board in board:
			if each_board[move-1] != 0:	#인형이 있는경우. 
				basket.append(each_board[move-1])	#basket에 인형 옮겨주기
				print(basket)
			if len(basket) >= 2:	#basket에 인형이 2개이상 있는 경우
				if basket[-2] == basket[-1]:	#같은 인형이면
					del basket[-1]	#마지막으로 들어간 인형삭제
					del basket[-2]	#마지막 아래에 있는 인형삭제
					answer += 2	#터뜨린 인형 개수 추가 (+2)
					print(answer)
			each_board[move-1] = 0	#뽑은 인형자리 0으로 바꿔줌	
			break

	#이 코드와 차이가 뭔지....
	#for move in moves: # 사용자의 움직임 하나씩 출력
	#             for each_board in board: # columns 출력
	#                 # move는 1부터 시작하기 때문에 index로 사용하기 위해선 -1씩 해줘야 함
	#                 if each_board[move-1] != 0: # 만약 column의 move가 0이 아니라면 (인형이 있다는 말)
	#                     basket.append(each_board[move-1]) #해당 값을 인형 바구니에 담기

	#                     if len(basket) > 1: # 바구니에 인형이 2개 이상 들어가는데
	#                         if basket[-2] == basket[-1]: # 인형이 두개가 겹친다면
	#                             del basket[-2] # 터뜨린다
	#                             del basket[-1] # 터뜨린다
	#                             answer += 2 # 터뜨린 인형 갯수 추가

	#                     each_board[move-1] = 0 # 뽑은 인형은 0 처리
	#                     break 


	print(answer)

if __name__ == "__main__":
	main()
