from random import randrange
numPreSpike = randrange(5)+5
neg = 0
for x in range(0,numPreSpike):
    neg-=25
    print ("Spikes %r 0" % (neg))
    
numBricks1 = randrange(5)+5 #number from +X-N

for x in range(0,numBricks1):
    print ("Brick %r 0" % (x*59))
    
print("Spikes %r 0" % ((numBricks1*59)))
print("Spikes %r 0" % ((numBricks1*59)+25)) 

numBricks2 = randrange(5)+2 

for x in range(0,numBricks2):
    print ("Brick %r 0" % ((x*59)+50+(numBricks1*59)))

print("Spikes %r 0" % ((numBricks1*59)+50+ (numBricks2 * 59)))
print("Spikes %r 0" % ((numBricks1*59)+75+ (numBricks2 * 59)))  

numBricks3 = randrange(5)+5

for x in range(0,numBricks3):
    print ("Brick %r 0" % ((x*59)+100+(numBricks1*59)+(numBricks2*59)))

print ("flagEnd %r 55" % ((numBricks3*59)+(numBricks2*59)+(numBricks1*59)+50))

numOfCoins = randrange(20)+4
numOfClouds = randrange(15)+4        

for x in range(1,numOfCoins):
    yPos = randrange(90,135)
    xPos = randrange(-100,(numBricks3*59)+(numBricks2*59)+(numBricks1*59))
    print ("Coin %r %r" % (xPos, yPos))

for x in range(1,numOfClouds):
    yPos = randrange(150,275)
    xPos = randrange(-100,(numBricks3*59)+(numBricks2*59)+(numBricks1*59))
    print ("Cloud %r %r" % (xPos, yPos))

bush1 = randrange(4)+2
bush2 = randrange(4)+2

for x in range(1,bush1):
    xPos = randrange(0,(((numBricks1*59)-159)))
    print ("Bush %r %r" % (xPos, 59))

for x in range(1,bush2):
    xPos = randrange(100+(numBricks1*59)+(numBricks2*59),(numBricks3*59)+(numBricks2*59)+(numBricks1*59)-159)
    print ("Bush %r %r" % (xPos, 59))

numOfBullets = randrange(5)+4
for x in range(1,numOfBullets):
    yPos = randrange(59,275)
    xPos = randrange(480,(numBricks3*59)+(numBricks2*59)+(numBricks1*59)+1000)
    print ("Bullet %r %r" % (xPos, yPos))
