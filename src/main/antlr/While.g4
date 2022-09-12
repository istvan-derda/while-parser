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

VAR         :   [a-zA-Z][a-zA-Z0-9_]*;
CONST       :   '0'
            |   [1-9][0-9']*;
WS          :   [ \r\n\t]+ -> skip;
COMMENT     :   '/*' .*? '*/' -> skip;