# streams-vs-loops
Streams Versus Loops

For very tight loops, streams and collections don't compete with regular for loops
and arrays. Despite whatever performance costs you may have for these streams in this case, the
stream api and collections are far more readable, and, if looping over more
complicated functions, probably doesn't cost all that much.

This is more of a "Function calls cost" proof, and i will just assume the huge performance difference
may have more to do with what the JIT + L2 caches can pull off in the more dense example.

# Running this

I've ignored the two tests available. Remove the @Ignore's for the test you want
to run.

Pull Requests welcome.

# Run Results

On a 2013 Macbook Pro, Streams can finish the test case (2.5 Billion iterations
in innermost loop) in 23 seconds. Loops finishes the same test case in 4.

I've tried seeing if entrySet was causing it, but moving this outside of loops
was negligible, and reduced readability.

