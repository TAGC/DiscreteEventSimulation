echo "Print3 Simulation"
echo "-----------------"
java -ea -cp bin print3.Print3

echo
echo "Ticks Simulation"
echo "----------------"
java -ea -cp bin ticks.Ticks 10

echo
echo "Single Server Queue Simulation"
echo "------------------------------"
java -ea -cp bin ssq.SingleServerQueue 1987281099 4.0
