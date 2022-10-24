# arcade

Team names: Maddie, Sibel, Sophie

Project desciption: a video game interface that can be used to play either breakout or galaga

How to run/play the game: run the play class

design plan: v=variable, m=method
VideoGame(interface)
  setUp
  step
  advanceLevel
  keyInput
  addPowerUp
  
SuperClasses:
Weapon
  velocity v
  speed v
  size v
  imageView v
  
  move (abstract) m
  getView m
Breakable
  randomDice? v
  amountToBreak v
  pointValue v
  
  amountToBreak m
  pointValue m
  randomInRange m
  getView m
  startLocation (abstract) m
Character
  velocity v
  view v
  startX v
  startY v
  speed v
  
  reset m
  move m
  getView m
  
Breakout implements VideoGame
  Ball v is Weapon
    startX v
    startY v
    ballImage v
    
    reset m
    bounce m
    collide m
    move m
  Brick v is Breakable
    height v
    width v
    brickImage v
    brickView v
    
    brickHit
    startLocation m
  BlockBrick v is Brick
    brickImage v
    
    emptyBrickHit m
    startLocation m
  PowerUp v is Breakable
    size v
    image v
    
    startLocation m
  Paddle v is Character
    image v
  Player v
  
  brickCollision m
  addBlockBrick m
  setUpBricks m
Galaga implements VideoGame
  Laser v is Weapon
    laserImage v
    
    setLocation m
    move m
  Enemy v is Breakable
    height v
    width v
    image v
    imageView v
    
    enemyHit m
    enemyMove m
    startLocation m
  PowerUp v
  SpaceShip v is Character
    image v
  Player v

  
  setUpEnemy m
  enemyCollision m
