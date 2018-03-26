export default class Dice {
  constructor(numberGenerator) {
    this.numberGenerator = numberGenerator
  }

  roll() {
    const generatedNumber = this.numberGenerator()
    if (generatedNumber < 1) {
      return 1
    }

    if (generatedNumber > 6) {
      return 6
    }

    return generatedNumber
  }
}