import scala.annotation.tailrec

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
@main
def main(): Unit = {
  println(sum(40000, 0))
}

@tailrec
def sum(n: Long, accumulator: Long) : Long = {
  if(n == 1){
    return 1 + accumulator;
  }
  return sum(n-1, n+accumulator);
}

