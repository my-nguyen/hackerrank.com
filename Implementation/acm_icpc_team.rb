# INCOMPLETE CODE: submission to hackerrank.com failed at tests nos. 2, 3, 4, 5,
# 6, 7 because they take too long
require "benchmark"

def max_topics_teams(persons)
  max = 0
  count = 0
  (0..persons.length-2).each do |left|
    (left+1..persons.length-1).each do |right|
      # for each pair of persons, do a bitwise or on the pair, then count
      # the number of 1-bits in the result
      # puts("left: #{persons[left].to_i(2)}")
      # puts("#{persons[left]}")
      # puts("right: #{persons[right].to_i(2)}")
      # puts("#{persons[right]}")
      number = persons[left].to_i(2) | persons[right].to_i(2)
      one_bits = number.to_s(2).split(//).inject(0) { |s,i| s + i.to_i }

      # found a new maximum number of topics
      if (max < one_bits)
        max = one_bits
        count = 1
      # increment the number of teams that know the maximum number of topics
      elsif (max == one_bits)
        count += 1
      end
    end
  end
  return [max, count]
end

persons = []
numbers = gets.split
numbers[0].to_i.times do
  persons << gets.strip
end
result = max_topics_teams(persons)
puts("#{result[0]}\n#{result[1]}")
