# Number Base Converter
Number Base Converter project created as part of the Kotlin Basics course on JetBrains Academy

## Task:

### Description

Fractional numbers can also be converted from one base to another, so let's add this functionality to our program!

To convert a fractional number from one base to another, you need to split the number into two parts: integer and fractional. Convert each part from their base to decimal independently and then convert them (once again, separately) to the target base. Finally, combine both parts and get the final result!

The most challenging part will probably be converting the decimal fractional part to the target base. Don't worry, though: since you already know how to convert fractions from decimal to binary, it should not be a problem for you! Converting fractions from decimal to any base is practically the same: just use the proper denominator, which is the target base, instead of 2.

Just like in the previous stage, the input numbers can be large. You might want to consider using `java.math.BigDecimal` to handle large fractions.

### Objectives

Your program should behave almost the same way as in the previous stage: the two-level menu and the commands stay the same.

When your program gets a fractional number, it should output its representation in the target base rounded to 5 characters (digits or letters) in the fractional part. If there is no fractional part in the initial number, it should be omitted in the resulting number, too.
