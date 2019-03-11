import random
num=random.randint(1,100)
while True:
	print("A number between 1 and 100:")
	guess=input()
	i=int(guess)
	if i==num:
		print("Right.")
		break
	elif i<num:
		print("Try higher")
	elif i>num:
		print("Try lower")
