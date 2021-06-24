javac QueenBoardTester.java
java QueenBoardTester > output.txt
if diff -s output.txt expectedOutput.txt; then
	echo "Functions work correctly (throws not tested)"
else
	echo "Functions don't work correctly (throws not tested)"
fi
java QueenBoardTester throws;
