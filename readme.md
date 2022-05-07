Package for running naive bayes forecasting for gaussian distributed datasets.

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
  - [ ] Graphics generation for distribution and time series generation.
- [ ] Gaussian distribution
  - [ ] Stat methods
  - [ ] Naive bayes implementation