import Dice from '../src/Dice'

describe('DiceShould', () => {
  it('get a number equals or greater than 1', () => {
    const dice = new Dice(() => {
      return 0
    })

    const result = dice.roll()

    expect(result).toBe(1)
  })

  it('get a number equals or lower than 6', () => {
    const dice = new Dice(() => {
      return 8
    })

    const result = dice.roll()

    expect(result).toBe(6)
  })

  it('get a random number between 1 and 6', () => {
    const dice = new Dice(() => {
      return 4
    })
    
    const result = dice.roll()

    expect(result).toBe(4)
  })
})
