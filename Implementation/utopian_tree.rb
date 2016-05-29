def utopian_tree(number)
  growth = 1
  (1..number).each do |cycle|
    # spring growth: double in height
    if cycle % 2 == 1
      growth *= 2
    # summer growth: just add 1 meter
    else
      growth += 1
    end
  end
  return growth
end


(1..gets.to_i).each do
  number = gets.strip.to_i
  puts(utopian_tree(number))
end
