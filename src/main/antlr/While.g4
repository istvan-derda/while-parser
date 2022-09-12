grammar While;
expressions :   expr ';' expressions
            |   expr ';';
expr        :   VAR '=' CONST
            |   VAR '=' VAR '+' CONST
            |   VAR '=' VAR '-' CONST
            |   'LOOP' VAR 'DO' expressions 'END'
            |   'WHILE' VAR 'DO' expressions 'END';

VAR         :   [a-zA-Z][a-zA-Z0-9_]*;
CONST       :   '0'
            |   [1-9][0-9']*;
WS          :   [ \r\n\t]+ -> skip;
COMMENT     :   '/*' .*? '*/' -> skip;