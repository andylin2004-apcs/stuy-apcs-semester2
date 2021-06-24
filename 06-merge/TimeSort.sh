javac Driver.java;
javac ComparisonDriver.java;
TIMEFORMAT=%R
TIMES=(4000 8000 16000 32000 64000 128000 256000 512000 1024000 10000000)
echo "equal values"
for t in ${TIMES[@]}; do
  echo $t;
  echo "My time: ";
  time java Driver $t equal;
  echo "Array time: ";
  time java ComparisonDriver $t equal;
done
echo "--------------------"
echo "sorted values"
for t in ${TIMES[@]}; do
  echo $t;
  echo "My time: ";
  time java Driver $t sorted;
  echo "Array time";
  time java ComparisonDriver $t sorted;
done
echo "--------------------"
echo "random values"
for t in ${TIMES[@]}; do
  echo $t;
  echo "My time: ";
  time java Driver $t random;
  echo "Array time";
  time java ComparisonDriver $t random;
done
echo "--------------------"
echo "reversed values"
for t in ${TIMES[@]}; do
  echo $t;
  echo "My time: ";
  time java Driver $t reversed;
  echo "Array time";
  time java ComparisonDriver $t reversed;
done
