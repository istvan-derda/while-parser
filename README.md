# Simple While-Program Parser built with ANTLR

A simple parser I built for my parsing class at Leipzig University.

## What Does It Do?

This program simply parses valid while program files. On invalid input it throws an Exception and crashes. After parsing, 
it traverses the parse tree and prints some debug output to stdout. It is nothing more than a proof of concept, it should be 
reasonably straight forward to extend it to be an interpreter for while programs.

## How To Build & Run

**Build**

`mvn package` To generate the parser sourcefiles, compile the java code and package it to a .jar file with all dependencies.

**Run**

Run `java -jar target/while-parser-1.0-SNAPSHOT.jar src/test/antlr/example.while`

## Supported Language

This parser parses WHILE Programs, which are used in theoretical computer science for proving computability. 
WHILE Programs do not have any useful practical application beyond that.

It supports the basic structure of WHILE Programs:
- Variable Assignment `VAR = VAR + CONST` and `VAR = VAR - CONST`
- Sequence of Programs `program; program`
- WHILE loops `WHILE VAR DO programs END`

And it supports some syntactic sugar like the `LOOP` statement and `VAR = VAR` as well as `VAR = CONST` for user-friendliness.

**Grammar:**
```ANTLRv4
grammar While;
programs    :   program ';' programs
            |   program ';'
            |   EOF;
program     :   VAR '=' CONST
            |   VAR '=' VAR
            |   VAR '=' VAR '+' CONST
            |   VAR '=' VAR '-' CONST
            |   'LOOP' VAR 'DO' programs 'END'
            |   'WHILE' VAR 'DO' programs 'END';
```

**Example Program:**
```WHILE
/* SIMULATE LOOP WITH WILE */
i = 10;
WHILE i DO
    //do something
    i = i - 1;
END;

/* ADD TWO NUMBERS */
x_1 = 8;
x_2 = 9;
LOOP x_1 DO
    x_2 = x_2 + 1;
END;
```

## Why ANTLR?

I decided to use ANTLR after I experimented with Flex&Bison as well as JavaCC.
What convinced me to go with ANTLR was the good IDE integration with IntelliJ and the fact that the grammar files
are not polluted with code, which makes things a lot more readable in my opinion. Also, this allows for using the same
grammar source files with different programming languages, which makes the tool a lot more versatile than any of the
other parser generators I tried. In conclusion, I did not care much for which type of parser it would generate, as long as it is
reasonably performant and developer-friendly. It is the tool I could see myself actually using in the languages and ecosystems I currently work in. (JVM, JS, Python)
