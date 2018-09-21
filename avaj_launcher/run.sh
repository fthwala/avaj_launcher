find . -name "*.java" > sources.txt
javac -sourcepath . @sources.txt
java avaj.simulator.Simulator avaj/scenario.txt

# find . -name "*.java" > sources.txt
# javac -sourcepath . @sources.txt
# java avaj.weather.Simulator avaj/scenario.txt
