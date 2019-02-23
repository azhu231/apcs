df <- read.csv("squigglybikeroute.csv", sep=";")
df$x <- 6371000*(df$longitude)*pi/180*cos((mean(df$latitude*pi/180)))
df$y <- 6371000*(df$latitude)*pi/180
plot(df$x, df$y, type="l")
dist <- cumsum((diff(df$x)^2+diff(df$y)^2)^0.5)
df$elevation <- df$altitude..ft.*0.3048
plot(dist, df$elevation[-1], type='l')
slope <- diff(df$elevation[-1])/diff(dist)
angle <- atan(slope)
plot(dist[-1], angle*180/pi, type = "l")
interp_angle <- approxfun(dist[-1],angle)
interp_elevation <- approxfun(dist, df$elevation[-1])
calc.drag.force <- function(velocity)
{
  return(0.5*1.2*0.55*1.15*velocity^2)
}
calc.drag.force(2)
calc.roll.force = function(angle) {
  m=80
  g=9.81
  CR = 0.007
  m*g*cos(angle)
}

calc.grav.force <- function(angle) {
  m=80
  g=9.81
  m*g*sin(angle)
}

calc.prop.force <- function(velocity) {
  max.power <- 100 # watts
  max.power/velocity
}