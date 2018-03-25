package fromArticles.memoization

object GenericMemoization {
  def memoizeFnc[K, V](f: K => V): K => V = {
    var cache = Map.empty[K, V]
    k => {
      if (!cache.contains(k)) cache = cache updated(k, f(k))
      cache(k)
    }
  }

  def concat3Strings(str1: String, str2: String, str3: String): String = str1 + str2 + str3

  def add(a: Int, b: Int): Int = a + b

  val memoizedAdd = memoizeFnc(add _ tupled)

  val memoizedConcat = memoizeFnc(concat3Strings _ tupled)
}
