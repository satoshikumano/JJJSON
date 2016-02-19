# JJJSON
Library to deal with loosely typed JSON.

Sometimes you need to parse JSON which is loosely typed.
For example, You know it is the JSON Object, but inside the object same key could bound to multiple types.

How you deal with the situation is depends on the library you're using though,
In general you can check the type by `instanceOf` operator and branch the procedure with if/else if statement.
Or you will use the method like `getString(String key)` which throws exception or returns nil when your assumption was not valid.

Yes. It works perfectly. But I feel bit tired of those approaches.
Since those codes could be lengthy and somehow boring.

JJJSON design is aim to
 - Allow you to focus on coding when assumption is valid.
 - Clean arrangement of different assumptions.
 - Optional handler when the assumption is invalid. (May used to claim that the given JSON is unacceptable format and violating contract in your System.)
 
You can see the example [here](https://github.com/satoshikumano/JJJSON/blob/master/Example/src/Example.java).
 
