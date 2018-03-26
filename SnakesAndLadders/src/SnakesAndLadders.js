export default class SnakesAndLadders {
  constructor(dice) {
    this.position = 1
    this.dice = dice
  }
  getPlayerPosition() {
    return this.position
  }
  doTurn() {
    const steps = this.dice.roll()
    this.position += steps
  }
}