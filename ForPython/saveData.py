game_data={'position':'N35 E45','pockets':['keys','pocket knife','polished stone'],'backpack':['rope','hammer','apple'],'money':180.5}
import pickle
save_file=open('c:\\users\lenovo\desktop\save.dat','wb')
pickle.dump(game_data,save_file)
save_file.close()
load_file=open("c:\\users\lenovo\desktop\save.dat",'rb')
loaded_game_data=pickle.load(load_file)
print(loaded_game_data)
