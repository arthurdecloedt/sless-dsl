# Sless

## Extensibility

The ParserBase function will probably always have to be changed, in addition to that changes in the appropriate files will have to be made, every concept has its own file, and they are organised in an hierarchy for declarations and selectors.
## Extra

The lint test has an extra test to test a custom extension.
Special attention was paid to allow for very complex nesting possibility in Declarations and Selections, no mutable variables were used, all operations on collections were done with higher order functions, implemented comments extension

## Better Values

/

## Improving original features

/
## Custom Extension

I have extended the lintDSL, it now allows to check for clashing rules/declarations in which a property is is assigned 2 different values while having an selector overlap.
It is however important to consider that this doesn't always mean an error. Sometimes these duplicate rules are used for expressing things to browsers that have differing levels of css support.
More information here: https://github.com/CSSLint/csslint/wiki/Disallow-duplicate-properties
The check checks across rules different rules or and within a single rule.
It is split in a check and a method to get the string representation for all of them because it does an exhaustive search which is short circuited in the check.
The check is (for the selector comparison) based on the hash implementation for case classes. (lazy vals are used instead of functions to reduce repeating the same task)
## Feedback on the Project 

Project was very nice, scala is a language one can write pretty fast in as it combines the expressability of a functional language with the familiarity of Java