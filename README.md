# arcade

Team names: Maddie, Sibel, Sophie

Project desciption: a video game interface that can be used to play either breakout or galaga

How to run/play the game: run the play class

design plan: v=variable, m=method
# VideoGame(interface) (maddie)
  - setUp
  - step
  - advanceLevel
  - keyInput
  - addPowerUp
  
# SuperClasses:
- Weapon (sibel)
  - velocity (v)
  - speed (v)
  - size (v)
  - imageView (v)
  
  - move (abstract) (m)
  - getView (m)
- Breakable (sophie)
  - randomDice? (v)
  - amountToBreak (v)
  - pointValue (v)
  
  - amountToBreak (m)
  - pointValue (m)
  - randomInRange (m)
  - getView (m)
  - startLocation (abstract) (m)
- Character (sibel)
  - velocity (v)
  - view (v)
  - startX (v)
  - startY (v)
  - speed (v)
  
  - reset (m)
  - move (m)
  - getView (m)
  
# Breakout implements VideoGame
 - Ball (v) extends Weapon
  - startX (v)
  - startY (v)
  - ballImage (v)

  - reset (m)
  - bounce (m)
  - collide (m)
  - move (m)
- Brick (v) extends Breakable
  - height (v)
  - width (v)
  - brickImage (v)
  - brickView (v)

  - brickHit (m)
  - startLocation (m)
- BlockBrick (v) extends Brick
  - brickImage (v)

  - emptyBrickHit (m)
  - startLocation (m)
- PowerUp (v) extends Breakable
  - size (v)
  - image (v)

  - startLocation (m)
- Paddle (v) extends Character
  - image (v)
- Player (v)

 - brickCollision m
 - addBlockBrick m
- setUpBricks m

# Galaga implements VideoGame
- Laser (v) extends Weapon
  - laserImage (v)
  - setLocation (m)
  - move (m)
- Enemy (v) extends Breakable
  - height (v)
  - width (v)
  - image (v)
  - imageView (v)

  - enemyHit (m)
  - enemyMove (m)
  - startLocation (m)
- PowerUp (v) extends Breakable
  - size (v)
  - image (v)

  - startLocation (m) 
- SpaceShip (v) extends Character
  - image v
- Player (v)

- setUpEnemy (m)
- enemyCollision (m) 
  
![IMG_1564](https://user-images.githubusercontent.com/113381324/197603108-1b4bbffa-5355-4f57-a8a5-684143302ed8.jpeg)
![IMG_1566](https://user-images.githubusercontent.com/113381324/197603112-eaf6564c-498e-4855-bf91-bda0b0aa9e37.jpeg)
![IMG_1565](https://user-images.githubusercontent.com/113381324/197603116-9264bc20-d9ac-4fb8-9346-90e3f88b165c.jpeg)
