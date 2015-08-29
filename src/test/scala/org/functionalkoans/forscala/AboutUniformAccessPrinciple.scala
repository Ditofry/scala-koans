package org.functionalkoans.forscala

import support.KoanSuite

class AboutUniformAccessPrinciple extends KoanSuite {
  // Notice that only currentYear is accessor
  class CalculatesAgeUsingMethod(var currentYear: Int, birthYear: Int) {

    def age = currentYear - birthYear

    // calculated when method is called
  }

  class CalculatesAgeUsingProperty(var currentYear: Int, birthYear: Int) {
    // does age stay up to date if defined as a var instead of a val?
    // A: It shouldn't... that would defeat the purpose of val
    val age = currentYear - birthYear
    // calculated at instantiation, returns property when called
  }

  koan("Can access age as parameterless method") {
    val me = new CalculatesAgeUsingMethod(2010, 2003)
    me.age should be(7)
  }

  koan("Can access age as property") {
    val me = new CalculatesAgeUsingProperty(2010, 2003)
    me.age should be(7)
  }

  koan("Cannot add parameter to Method invocation") {
    val me = new CalculatesAgeUsingMethod(2010, 2003)
    // uncomment following line to see what happens if you try to access parameterless method with parens
    // me.age() should be (7)
  }
  koan("What happens when I update current year using property") {
    val me = new CalculatesAgeUsingProperty(2010, 2003)

    // Age is a val, so it won't change
    me.currentYear = 2011
    me.age should be(7)
  }

  koan("What happens when I update current year using method") {
    val me = new CalculatesAgeUsingMethod(2010, 2003)

    // Since age is a method it can change
    me.currentYear = 2011
    me.age should be(8)
  }

}
