# version 2: has only one loop, and there's no accessing array elements
def filling_jars(jar_count, operations)
  sum = operations.inject(0) do |total, operation|
    # operation[1]-operation[0]+1: refers to all array elements from lower
    # bound to upper bound, inclusive
    # operation[2] is the number of candies to fill into those array elements
    # So at each iteration, the number of candies filled in all array elements
    # from lower bound to upper bound inclusive is added to the total
    # And at the end of the loop, the sum will be all candies filled in all
    # ranges (lower-upper) of all operations
    total += (operation[1]-operation[0]+1) * operation[2]
  end

  # return the average candies per jar
  return sum / jar_count
end

operations = []
commands = gets.split.map(&:to_i)
commands[1].times do
  operations << gets.split.map(&:to_i)
end
puts(filling_jars(commands[0].to_i, operations))
