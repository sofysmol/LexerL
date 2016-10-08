# LexerL
This is a console application that demonstrates the working of Lexer for a language L.
### Languege L
X - countably infinite set of variables

&otimes; = {+, −, ∗, /, %, ==, !=, >, >=, <, <=, &&, ||,**}
Comments: 

```
    //oneline comment
    (*
     multiline comment
    *)
```

  - Expression: E=X &cup; &#x2115; &cup; (E &otimes; E). In expressions you can use parentheses.
  - Operators: S = skip &cup; X := E ∪ S ; S ∪ write E ∪ read E ∪ while E do S ∪
if E then S else S
  - Programs P = S
  
Example program

```
    read x; if y + 1 == x then write y else skip
```

 The result of the lexical analysis
    
```
KW_Read(0;0;4);Var("x";0;5;6);Colon(0;6;6);KW_If(0;7;9);Left_Paren(0;10;10);Var("y";0;11;12);Op(Plus;0;13;13);Num(17;0;15;17);Right_Paren(0;17;17);Op(Eq;0;19;19);Op(Eq;0;20;20);Var("x";0;22;23);KW_Then(0;24;28);KW_Write(0;29;34);Var("y";0;35;36);KW_Else(0;37;41);KW_Skip(0;42;46);
```

### Build
 - If you don't have maven, install mvn
```sh
$ sudo apt-get install maven
```

 - Change directory on "LexerL"
 - Install project LexerL
```sh
$ mvn install
```

### Run
 - Change directory on "target"
 - run lexerl-1.0-SNAPSHOT-jar-with-dependencies.jar
 
 ```sh
 $ java -jar  lexerl-1.0-SNAPSHOT-jar-with-dependencies.jar filepath
 ```
