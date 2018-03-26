import SnakesAndLadders from '../src/SnakesAndLadders'
import Dice from '../src/Dice'

describe('SnakesAndLaddersShould', () => {
  let snakesAndLadders
  let dice

  beforeEach(() => {
    dice = new Dice()
    dice.roll = jest.fn(() => {
      return 3
    })
    snakesAndLadders = new SnakesAndLadders(dice)
  })

  it('have a token in the first square', () => {
    expect(snakesAndLadders.getPlayerPosition()).toBe(1)
  })

  it('move some steps forward after dice roll', () => {
    snakesAndLadders.doTurn()
    
    expect(dice.roll).toHaveBeenCalled()
    expect(snakesAndLadders.getPlayerPosition()).toBe(4)
  })
  
})
