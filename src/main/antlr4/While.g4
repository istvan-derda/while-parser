grammar While;
programs    :   program ';' programs
            |   program ';'
            |   EOF;
program     :   assignConst
            |   assignVar
            |   addConst
            |   subtrConst
            |   loop
            |   while;

assignConst :   VAR '=' CONST;
assignVar   :   VAR '=' VAR;
addConst    :   VAR '=' VAR '+' CONST;
subtrConst  :   VAR '=' VAR '-' CONST;
loop        :   'LOOP' VAR 'DO' programs 'END';
while       :   'WHILE' VAR 'DO' programs 'END';

VAR         :   [a-zA-Z][a-zA-Z0-9_]*;
CONST       :   '0'
            |   [1-9][0-9']*;
WS          :   [ \r\n\t]+ -> skip;
BLKCOMMENT  :   '/*' .*? '*/' -> skip;
LINECOMMENT :   '//' .*? '\n' -> skip;
