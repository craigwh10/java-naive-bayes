Package for running naive bayes forecasting for gaussian distributed datasets.

Aiming to work against an example of classifying cryptocurrencies using [kaggle dataset](https://www.kaggle.com/datasets/sudalairajkumar/cryptocurrencypricehistory)

---
### To run

- Requires [Java 17 LTS](https://www.oracle.com/java/technologies/downloads/).
- As defined in `build.gradle`, to change this in IDE on Mac-IntelliJ, go to `file` > `project structure` > `project` > `jdk`

Then..

```
gradle run
```

### Tests:

Uses [assertJ](http://joel-costigliola.github.io/assert).

```
gradle test
```

---

### Todo:
- [ ] Stretch tasks
  - [ ] Remove lambda expressions
  - [ ] Performance monitoring
  - [ ] Graphics generation for distribution and time series generation
- [ ] Gaussian distribution
  - [ ] Generating classes for classifier 
  - [ ] Stat methods
  - [ ] Naive bayes implementation

---

Notes:

- To use a modular setup right click the java dir, open module settings then control them there, otherwise modules are added outside the scope of the core reverse dns style package.