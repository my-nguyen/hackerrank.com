# version 1: takes too long, because two loops are employed, plus an
# assignement to an array element within the inner loop
def filling_jars(jar_count, operations)
  jars = Array.new(jar_count, 0)
  operations.each do |operation|
    # operation[0]-1 is jars' lower bound, operation[1]-1 is jars' upper bound
    (operation[0]-1..operation[1]-1).each do |index|
      # add candies into a jar
      jars[index] += operation[2]
    end
  end

  # return the average candies per jar
  return jars.inject{ |sum,e| sum += e } / jar_count
end

operations = []
commands = gets.strip.split(" ").map(&:to_i)
commands[1].times do
  operations << gets.strip.split(" ").map(&:to_i)
end
puts(filling_jars(commands[0].to_i, operations))
