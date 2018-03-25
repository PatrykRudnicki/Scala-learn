package fromArticles.memoization

object Memoization {
  def memoizedIsPrime: Int => Boolean = {
    def checkIfPrime(i: Int): Boolean = {
      2 to (i - 1) forall (x => i % x != 0)
    }

    var cache = Map.empty[Int, Boolean]
    i => {
      if (!cache.contains(i)) {
        print(s"Calling isPrime since input ${i} has not been seen before and caching the output")
        cache = cache updated(i, checkIfPrime(i))
      }
      else print(s"Input ${i} has been seen before , returning cached output")
      cache(i)
    }
  }

  val isPrime = memoizedIsPrime

  println(isPrime(9))
  println(isPrime(7))
  println(isPrime(9))
}


//Some important points to note :-

//When implementing lazy loading caches like the cache variable above, we can use either a val referring to a mutable Map or a var referring to an immutable Map. The reason I prefer the latter is because even if we accidentally pass the reference around, the map it points to can’t be mutated .
//The mutability of the cache reference is not visible outside the memoizedIsPrime function . Thus, it is a pure function and we are not violating referential transparency. Cache updation is done ONLY by the function returned by memoizedIsPrime (which forms a closure over the cache).
//isPrime is defined as a val since we only want one instance of the cache. If we define it as using def, every call to it will result into a new instance of the cache and we will not achieve memoization.