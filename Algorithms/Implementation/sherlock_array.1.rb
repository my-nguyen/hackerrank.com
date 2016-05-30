# version 1: overdid the requirement due to misinterpretation of the problem statement
def process(numbers)
  # puts(numbers.to_s)
  not_found = true
  # first move the pivot. note the use of the traditional for loop instead of
  # the each loop, because of the additional not_found condition.
  # for (pivot = 1; pivot < numbers.length-1 && not_found; pivot++)
  # (1..numbers.length-2).each do |pivot|
  pivot = 1
  while (pivot < numbers.length-1 && not_found)
    # next take the sum of all the ranges to the right of the pivot
    # for (right = pivot+1; right < numbers.length && not_found; right++)
    # (pivot+1..numbers.length-1).each do |right|
  #  puts("pivot: #{pivot}")
    right = pivot+1
    while (right < numbers.length && not_found)
      sum_right = numbers[pivot+1..right].inject(0) {|sum, i| sum + i }
  #    puts("sum_right: #{sum_right}")
      # compare each such sum on the right with all the sum to the left of pivot
      # for (left = pivot-1; left >= 0 && not_found; left--)
      # (pivot-1).downto(0) do |left|
      left = pivot-1
      while (left >= 0 && not_found)
        sum_left = numbers[left..pivot-1].inject(0) {|sum, i| sum + i }
  #      puts("sum_left: #{sum_left}")
        # break out of all loops when we find a match
        if sum_right == sum_left
          puts("left[#{left}..#{pivot-1}]: #{numbers[left..pivot-1]}")
          puts("right[#{pivot+1}..#{right}]: #{numbers[pivot+1..right]}")
          not_found = false
        end
        left -= 1
      end
      right += 1
    end
    pivot += 1
  end
  return not_found ? "NO" : "YES"
end

gets.to_i.times do |j|
  # read and throw away this number
  gets
  puts(process(gets.split.map{|i| i.to_i}))
end
