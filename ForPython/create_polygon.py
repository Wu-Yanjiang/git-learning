from tkinter import*
tk=Tk()
canvas=Canvas(tk,width=400,height=400)
canvas.pack()

canvas.create_polygon(200,10,240,30,120,100,140,120,fill='',outline="black")
