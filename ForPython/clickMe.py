from tkinter import*
def hello():
	print("Hello ha.")
	
tk=Tk()
btn=Button(tk,text=("Click me"),command=hello)
btn.pack()
